package org.springrain.front.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class SearchResult implements Serializable {
	private long recourdCount;
	private int totalPages;
	private List<SearchMovie> movieList;
	public long getRecourdCount() {
		return recourdCount;
	}
	public void setRecourdCount(long recourdCount) {
		this.recourdCount = recourdCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<SearchMovie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<SearchMovie> movieList) {
		this.movieList = movieList;
	}
	@Override
	public String toString() {
		return "SearchResult [recourdCount=" + recourdCount + ", totalPages=" + totalPages
				+ ", movieList=" + movieList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + (int) (recourdCount ^ (recourdCount >>> 32));
		result = prime * result + totalPages;
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
		SearchResult other = (SearchResult) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (recourdCount != other.recourdCount)
			return false;
		if (totalPages != other.totalPages)
			return false;
		return true;
	}
	public SearchResult() {
		super();
	}
	public SearchResult(long recourdCount, int totalPages, List<SearchMovie> movieList) {
		super();
		this.recourdCount = recourdCount;
		this.totalPages = totalPages;
		this.movieList = movieList;
	}
	
	
}
