package api.payload;

public class DetectDevicePojo {
	
	
	String model_number  = "RMX1971";
	int internal_memory = 4 ;
	int internal_storage =64;
	String cpu_model = "Qualcomm Technologies";
	
	
	
	public String getModel_number() {
		return model_number;
	}
	public void setModel_number(String model_number) {
		this.model_number = model_number;
	}
	public int getInternal_memory() {
		return internal_memory;
	}
	public void setInternal_memory(int internal_memory) {
		this.internal_memory = internal_memory;
	}
	public int getInternal_storage() {
		return internal_storage;
	}
	public void setInternal_storage(int internal_storage) {
		this.internal_storage = internal_storage;
	}
	public String getCpu_model() {
		return cpu_model;
	}
	public void setCpu_model(String cpu_model) {
		this.cpu_model = cpu_model;
	}
	

}
