package org.zoo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Room implements Serializable {
	
	private static final Long serialVersionUID = 1896118L;
	
	@Id
	@GeneratedValue
	private Long roomId;
	
	public Long getRoomId() { return roomId; }
	public void setRoomId(Long roomId) {  this.roomId = roomId; }
	
	@Override
	public int hashCode() { return roomId.hashCode(); }
	
	@Override
	public boolean equals(Object o) {
		return (o != null && o instanceof Room && ((Room)o).roomId.equals(roomId));
	}
	
}