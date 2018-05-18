package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore primaryTS;
  private TorpedoStore secondaryTS;

  @Before
  public void init(){
	  this.primaryTS = mock(TorpedoStore.class);
	  this.secondaryTS = mock(TorpedoStore.class);
	  this.ship = new GT4500(primaryTS, secondaryTS);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
	  when(primaryTS.fire(1)).thenReturn(true);
    // Act
	  boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
	// Verifying the mock
	  assertEquals(true, result);
	  verify(primaryTS, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
	  when(primaryTS.isEmpty()).thenReturn(false);
	  when(primaryTS.fire(1)).thenReturn(true);
	  when(secondaryTS.isEmpty()).thenReturn(false);
	  when(secondaryTS.fire(1)).thenReturn(true);
    // Act
	  boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
	// Verifying the mock
	  assertEquals(true, result);
	  verify(primaryTS, times(1)).fire(1);
	  verify(primaryTS, times(1)).fire(1);
  }
  
  @Test
  public void fireTorpedo_Single_primaryFiredLast() {
	  // Arrange
	  when(primaryTS.isEmpty()).thenReturn(false);
	  when(secondaryTS.isEmpty()).thenReturn(false);
	  // Act
	  ship.fireTorpedo(FiringMode.SINGLE);
	  ship.fireTorpedo(FiringMode.SINGLE);
	  // Verifying
	  verify(primaryTS, times(1)).fire(1);
	  verify(secondaryTS, times(1)).fire(1);
  }
  
  @Test
  public void fireTorpedo_Single_primaryFiredLast_else() {
	  // Arrange
	  
	  // Act
	  
	  // Verifying
	  
  }
}
