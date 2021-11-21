package barracksWars.core;

import barracksWars.core.commands.Add;
import barracksWars.core.commands.Command;
import barracksWars.core.commands.Fight;
import barracksWars.core.commands.Report;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException {
		String result = "";
		try {
			String up = commandName.substring(0,1).toUpperCase() + commandName.substring(1);
			Class<?> clazz = Class.forName("barracksWars.core.commands." + up);
			Constructor<Command> ctor = (Constructor<Command>) clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			Command com = ctor.newInstance(data, this.repository, this.unitFactory);
			Method ex = clazz.getDeclaredMethod("execute");
			try{
				result = (String) ex.invoke(com);
			}
			catch(InvocationTargetException e){
				System.out.print(e.getCause().getMessage());
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		return result;
	}
}
