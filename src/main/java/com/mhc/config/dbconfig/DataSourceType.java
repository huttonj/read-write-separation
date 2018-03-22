package main.java.com.mhc.config.dbconfig;


import lombok.Data;
import lombok.Getter;

/**
 * @author maihe
 */
public enum DataSourceType {

	READ("salve", "从库"),
	WRITE("master", "主库");

	@Getter
    private String type;

	@Getter
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
