package dev.sakura.Hub;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HubSettings {
	boolean chat();
	boolean particles();
	boolean online();
}
