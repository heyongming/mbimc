package com.wx.entitys.template;

public class DataRemark {
	  private String value;
	    
	    private String color;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public DataRemark(String value, String color) {
			super();
			this.value = value;
			this.color = color;
		}

		public DataRemark() {
			super();
		}

}
