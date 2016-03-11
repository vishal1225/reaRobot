package com.rea.robot.command.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.rea.robot.commands.ICommand;
import com.rea.robot.commands.LeftCommand;
import com.rea.robot.commands.MoveCommand;
import com.rea.robot.commands.PlaceCommand;
import com.rea.robot.commands.ReportCommand;
import com.rea.robot.commands.RightCommand;
import com.rea.robot.pojo.Command;
import com.rea.robot.pojo.Direction;
import com.rea.robot.util.ResourceUtil;

public class FileCommandReader extends AbstractCommandReader {
	private static Logger log = Logger.getLogger(LeftCommand.class.getName());
	private int maxXCordinate = Integer.parseInt(ResourceUtil.getPropertyValue("max.x"));
	private int maxYCordinate = Integer.parseInt(ResourceUtil.getPropertyValue("max.y"));

	@Override
	public List<ICommand> readCommand() {
		log.log(Level.INFO, "Reading Commands from file.");
		List<ICommand> commandList = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(getCommandFile()));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				final String[] split = sCurrentLine.split("\\s*(,|\\s)");
				if (commandList.isEmpty()) {
					if (checkValidInitCommand(split)) {
						commandList.add(new PlaceCommand(createPosition(split)));
					}
					// Discard any command other than initial PLACE
					else {
						continue;
					}
				} else {
					if (split.length == 1) {
						commandList.add(identifyCommand(Command.valueOf(split[0])));
					} else if (checkValidInitCommand(split)) {
						commandList.add(new PlaceCommand(createPosition(split)));
					} else {
						// seems to be an invalid command. Ignore it
						continue;
					}
				}
			}
		} catch (FileNotFoundException fileNotFoundException) {
			log.log(Level.SEVERE, fileNotFoundException.getMessage());
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}

		return commandList;
	}

	private boolean checkValidInitCommand(String[] split) {
		if ((Command.valueOf(split[0]).equals(Command.PLACE)) && (split.length == 4)) {
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			Direction direction = Direction.valueOf(split[3]);
			if ((x >= 0 && x < maxXCordinate) && (y >= 0 && y < maxYCordinate)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private ICommand identifyCommand(Command command) {
		ICommand concreteCommand = null;
		if (command.equals(Command.MOVE)) {
			concreteCommand = new MoveCommand();
		}
		if (command.equals(Command.LEFT)) {
			concreteCommand = new LeftCommand();
		}
		if (command.equals(Command.RIGHT)) {
			concreteCommand = new RightCommand();
		}
		if (command.equals(Command.REPORT)) {
			concreteCommand = new ReportCommand();
		}
		return concreteCommand;
	}

}
