package com.example.app.batch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.springframework.batch.item.ItemReader;

public class ExcelNoteReader implements ItemReader<ExcelNoteItem> {

	private final Iterator<ExcelNoteItem> iterator;

	public ExcelNoteReader(String filePath) throws IOException {

		List<ExcelNoteItem> notes = new ArrayList<>();

		try (FileInputStream inputStream = new FileInputStream(filePath);
				Workbook workbook = WorkbookFactory.create(inputStream)) {

			Sheet sheet = workbook.getSheetAt(0);

			DataFormatter formatter = new DataFormatter();

			boolean firstRow = true;

			for (Row row : sheet) {

				// Skip header row
				if (firstRow) {
					firstRow = false;
					continue;
				}

				Cell titleCell = row.getCell(0);
				Cell contentCell = row.getCell(1);

				if (titleCell == null && contentCell == null) {
					continue;
				}

				String title = titleCell == null ? "" : formatter.formatCellValue(titleCell).trim();

				String content = contentCell == null ? "" : formatter.formatCellValue(contentCell).trim();

				if (title.isEmpty() && content.isEmpty()) {
					continue;
				}

				notes.add(new ExcelNoteItem(title, content));
			}
		}

		this.iterator = notes.iterator();
	}

	@Override
	public ExcelNoteItem read() {

		if (iterator.hasNext()) {
			return iterator.next();
		}

		return null;
	}
}