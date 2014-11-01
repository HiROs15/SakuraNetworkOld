package dev.sakura.Commands.HubCommands;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HubCommandInfo {
	String command();
}
