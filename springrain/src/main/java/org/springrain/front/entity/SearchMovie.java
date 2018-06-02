package org.springrain.front.entity;

import java.io.Serializable;

import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class SearchMovie implements Serializable{
	private String id;
	private String name;
	private String doubanRating;
	private String releaseYear;
	private String directors;
	private String coverLink;
	private String types;
	private String actors;
	private String originPlace;
	private String languages;
	private String anotherNames;
	
	public String[] getImages(){
		if(StringUtils.isNotBlank(coverLink)){
		String[] split = coverLink.split(",");
		return split;
		}
		return null;
	}
	
	@Transient
	public Double getDoubanRatingDouble() {
		if (StringUtils.isNoneBlank(this.doubanRating)) {
			return Double.parseDouble(this.doubanRating);
		} else {
			return null;
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoubanRating() {
		return doubanRating;
	}

	public void setDoubanRating(String doubanRating) {
		this.doubanRating = doubanRating;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getCoverLink() {
		return coverLink;
	}

	public void setCoverLink(String coverLink) {
		this.coverLink = coverLink;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getOriginPlace() {
		return originPlace;
	}

	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getAnotherNames() {
		return anotherNames;
	}

	public void setAnotherNames(String anotherNames) {
		this.anotherNames = anotherNames;
	}

	@Override
	public String toString() {
		return "SearchMovie [id=" + id + ", name=" + name + ", doubanRating=" + doubanRating
				+ ", releaseYear=" + releaseYear + ", directors=" + directors + ", coverLink="
				+ coverLink + ", types=" + types + ", actors=" + actors + ", originPlace="
				+ originPlace + ", languages=" + languages + ", anotherNames=" + anotherNames + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((anotherNames == null) ? 0 : anotherNames.hashCode());
		result = prime * result + ((coverLink == null) ? 0 : coverLink.hashCode());
		result = prime * result + ((directors == null) ? 0 : directors.hashCode());
		result = prime * result + ((doubanRating == null) ? 0 : doubanRating.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((originPlace == null) ? 0 : originPlace.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchMovie other = (SearchMovie) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (anotherNames == null) {
			if (other.anotherNames != null)
				return false;
		} else if (!anotherNames.equals(other.anotherNames))
			return false;
		if (coverLink == null) {
			if (other.coverLink != null)
				return false;
		} else if (!coverLink.equals(other.coverLink))
			return false;
		if (directors == null) {
			if (other.directors != null)
				return false;
		} else if (!directors.equals(other.directors))
			return false;
		if (doubanRating == null) {
			if (other.doubanRating != null)
				return false;
		} else if (!doubanRating.equals(other.doubanRating))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (originPlace == null) {
			if (other.originPlace != null)
				return false;
		} else if (!originPlace.equals(other.originPlace))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

	public SearchMovie() {
		super();
	}

	public SearchMovie(String id, String name, String doubanRating, String releaseYear,
			String directors, String coverLink, String types, String actors, String originPlace,
			String languages, String anotherNames) {
		super();
		this.id = id;
		this.name = name;
		this.doubanRating = doubanRating;
		this.releaseYear = releaseYear;
		this.directors = directors;
		this.coverLink = coverLink;
		this.types = types;
		this.actors = actors;
		this.originPlace = originPlace;
		this.languages = languages;
		this.anotherNames = anotherNames;
	}
	
	
}	
