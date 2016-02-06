package by.ittc.horsebetting.model;

import java.util.List;

public class Race {

	private List<String> horsesNames;
	private String horsesId;
	private Float destination;
	private String status;
	private String date;
	private String coefficients;
	private String nameWinnerHorse;
	private Integer deleted;
	private String deletedDate;
	private int id;

	public Race() {
		this.status = "Waiting";
	}

	public String getNameWinnerHorse() {
		return nameWinnerHorse;
	}

	public void setNameWinnerHorse(String nameWinnerHorse) {
		this.nameWinnerHorse = nameWinnerHorse;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}

	public List<String> getHorsesNames() {
		return horsesNames;
	}

	public void setHorsesNames(List<String> horsesNames) {
		this.horsesNames = horsesNames;
	}

	public String getHorsesId() {
		return horsesId;
	}

	public void setHorsesId(String horsesId) {
		this.horsesId = horsesId;
	}

	public String getCoefficients() {
		return coefficients;
	}

	public void setCoefficients(String coefficients) {
		this.coefficients = coefficients;
	}

	public Float getDestination() {
		return destination;
	}

	public void setDestination(Float destination) {
		this.destination = destination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
