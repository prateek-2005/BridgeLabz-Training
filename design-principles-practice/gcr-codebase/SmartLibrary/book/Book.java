package book;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String title;
	private List<String> authors;
	private String edition;
	private String genre;
	private String publisher;

	private Book(Builder builder) {
		this.title = builder.title;
		this.authors = builder.authors;
		this.edition = builder.edition;
		this.genre = builder.genre;
		this.publisher = builder.publisher;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", authors=" + authors + ", edition=" + edition + ", genre=" + genre
				+ ", publisher=" + publisher + "]";
	}


	public static class Builder {
		private String title;
		private List<String> authors = new ArrayList<String>();
		private String edition;
		private String genre;
		private String publisher;

		public Builder(String title) {
			this.title = title;
		}

		public Builder addAuthor(String author) {
			authors.add(author);
			return this;
		}

		public Builder edition(String edition) {
			this.edition = edition;
			return this;
		}

		public Builder genre(String genre) {
			this.genre = genre;
			return this;
		}

		public Builder publisher(String publisher) {
			this.publisher = publisher;
			return this;
		}

		public Book build() {
			return new Book(this);
		}
	}

}