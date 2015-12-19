package tryspring.withxml;

import java.util.Date;

public class Post {
	
	// TODO
	private Integer id;
	private String title;
	private Date created;
	private Date lastChenged;
	private String content;
	private String tags;
	
	public Post() { }

	public Post(Integer id, String title, Date created, Date lastChenged, String content, String tags) {
		super();
		this.id = id;
		this.title = title;
		this.created = created;
		this.lastChenged = lastChenged;
		this.content = content;
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastChenged() {
		return lastChenged;
	}

	public void setLastChenged(Date lastChenged) {
		this.lastChenged = lastChenged;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", created=" + created + ", lastChenged=" + lastChenged
				+ ", content=" + content + ", tags=" + tags + "]";
	}

}
