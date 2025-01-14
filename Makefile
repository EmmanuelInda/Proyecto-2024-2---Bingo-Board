run: program
	java -Dsun.java2d.uiScale=1.0 -Dsun.java2d.dpiaware=true -cp out Main

program:
	javac -d out \
		src/*.java \
		src/ui/*.java \
		src/ui/panels/*.java \
		src/ui/mycolors/*.java \
		src/game/*.java \
		src/game/patterns/*.java
