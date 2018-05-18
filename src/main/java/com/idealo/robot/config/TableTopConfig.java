package com.idealo.robot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "tabletop")
public class TableTopConfig {

	private String minx;
	private String maxx;
	private String miny;
	private String maxy;
	
	public String getMinX() {
		return minx;
	}
	public void setMinX(String minx) {
		this.minx = minx;
	}
	public String getMaxX() {
		return maxx;
	}
	public void setMaxX(String maxx) {
		this.maxx = maxx;
	}
	public String getMinY() {
		return miny;
	}
	public void setMinY(String miny) {
		this.miny = miny;
	}
	public String getMaxY() {
		return maxy;
	}
	public void setMaxY(String maxy) {
		this.maxy = maxy;
	}

}
