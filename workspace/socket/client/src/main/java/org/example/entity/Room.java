package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.Socket;
import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
	private String kingName;
	private String roomName;
	private int socketPort;


}
