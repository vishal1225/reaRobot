package com.rea.robot.reader.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rea.robot.command.executer.CommandExecuter;
import com.rea.robot.command.reader.AbstractCommandReader;
import com.rea.robot.command.reader.FileCommandReader;
import com.rea.robot.commands.ICommand;
import com.rea.robot.exceptions.IllegalMoveException;
import com.rea.robot.pojo.Direction;
import com.rea.robot.robot.IRobo;
import com.rea.robot.robot.Robot;

public class CommandReaderTest {
	IRobo robo;

	@Before
	public void initRobo() {
		robo = new Robot();
	}
	@Test
	public void testCommandReader() throws URISyntaxException, FileNotFoundException, IOException, IllegalMoveException {
		AbstractCommandReader commandReader = new FileCommandReader();
		List<ICommand> commandList = null;
		File CommandFile = new File(this.getClass().getClassLoader().getResource("testing.txt").getFile());
		commandReader.setCommandFile(CommandFile);
		commandList = commandReader.readCommand();
		CommandExecuter.executeCommand(commandList, robo);
		assertEquals(3, robo.getPosition().getX());
		assertEquals(3, robo.getPosition().getY());
		assertEquals(Direction.NORTH, robo.getPosition().getFacing());
	}
}
