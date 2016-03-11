package com.rea.robot.command.executer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.rea.robot.commands.ICommand;
import com.rea.robot.commands.LeftCommand;
import com.rea.robot.exceptions.IllegalMoveException;
import com.rea.robot.robot.IRobo;

public class CommandExecuter {
	private static Logger log = Logger.getLogger(LeftCommand.class.getName());
	public static void executeCommand(List<ICommand> commandList, IRobo robo)   {
		log.log(Level.INFO, "Executing commands.");
		for (ICommand command : commandList) {
			try {
				command.execute(robo);
			} catch (IllegalMoveException e) {
				log.log(Level.WARNING, e.getMessage());
			}
		}
	}

	public static void executeCommand(ICommand command, IRobo robo) throws IllegalMoveException {
		command.execute(robo);
	}
}
