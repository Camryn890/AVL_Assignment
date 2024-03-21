# binary tree search program and array program makefile
# Camryn Palm
# 08 March 2024

JAVAC = /usr/bin/javac
.SUFFIXES : .java .class

.java.class:
	$(JAVAC) $<

classes: Origin.class BinaryTreeNode.class BinaryTree.class \
         BTQueueNode.class BTQueue.class \
         AVLTree.class GenericsKbAVLApp.class \
	 	 UserInterface.class

default: $(CLASSES)

clean:
	rm *.class

