package org.example;

import java.awt.EventQueue;

import org.example.view.ChattingClient;

public class ClientViewMain {
    public static void main(String[] args) {
    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = ChattingClient.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
