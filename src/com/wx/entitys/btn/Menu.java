package com.wx.entitys.btn;

public class Menu {
	private Button[] button;

	public Menu() {
		super();
	}

	public Menu(Button[] button) {
		super();
		this.button = button;
	}

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}
}
