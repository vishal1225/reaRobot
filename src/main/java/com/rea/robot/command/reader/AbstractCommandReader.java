package com.rea.robot.command.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.rea.robot.commands.ICommand;
import com.rea.robot.pojo.Direction;
import com.rea.robot.pojo.Position;

public abstract class AbstractCommandReader {
	private File commandFile = null;

	public File getCommandFile() {
		return commandFile;
	}

	public abstract List<ICommand> readCommand() throws FileNotFoundException, IOException;

	public void setCommandFile(File file) {
		this.commandFile = file;
	}

	public Position createPosition(String[] split) {
		int x = Integer.parseInt(split[1]);
		int y = Integer.parseInt(split[2]);
		Direction direction = Direction.valueOf(split[3]);
		return new Position(x, y, direction);
	}

}
