package com.example.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoteBatchService {

	private final JobLauncher jobLauncher;
	private final Job importNotesJob;

	public NoteBatchService(JobLauncher jobLauncher, Job importNotesJob) {

		this.jobLauncher = jobLauncher;
		this.importNotesJob = importNotesJob;
	}

	public String importNotes(MultipartFile file, int userId) throws Exception {

		if (file == null || file.isEmpty()) {
			throw new IllegalArgumentException("Excel file is required");
		}

		String originalFilename = file.getOriginalFilename();

		if (originalFilename == null || (!originalFilename.endsWith(".xlsx") && !originalFilename.endsWith(".xls"))) {

			throw new IllegalArgumentException("Only Excel files are allowed");
		}

		Path tempFile = Files.createTempFile("fundoo-notes-", "-" + UUID.randomUUID() + ".xlsx");

		try {

			file.transferTo(tempFile);

			JobParameters jobParameters = new JobParametersBuilder()

					.addString("filePath", tempFile.toAbsolutePath().toString())

					.addLong("userId", (long) userId)

					.addLong("timestamp", System.currentTimeMillis())

					.toJobParameters();

			JobExecution execution = jobLauncher.run(importNotesJob, jobParameters);

			if (execution.getStatus().isUnsuccessful()) {

				throw new RuntimeException("Batch import failed: " + execution.getAllFailureExceptions());
			}

			return "Notes imported successfully";

		} finally {

			Files.deleteIfExists(tempFile);
		}
	}
}