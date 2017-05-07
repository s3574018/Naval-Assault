package bits.navalassault.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StatusBar {
	public final StringProperty statusUpdate;
	
	//default constructor
	public StatusBar() {
		this(null);
	}
	
	public StatusBar(String statusUpdate) {
		this.statusUpdate = new SimpleStringProperty(statusUpdate);
	}
	
	public String getStatusUpdate() {
		return statusUpdate.get();
	}
	
	public void setStatusUpdate(String statusUpdate) {
		this.statusUpdate.set(statusUpdate);
	}
	
	public StringProperty statusProperty() {
		return statusUpdate;
	}
}
