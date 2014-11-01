package dev.sakura.Commands.RanksCommands;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RanksCommandInfo {
	String command();
}
