package com.javadude.fileclosing;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public abstract class AutoCloser {
	// HOOK METHOD - USERS WILL OVERRIDE
	protected abstract void doWork() throws Throwable;
	
	// USERS WRAP ALL CLOSEABLES WITH autoClose(...) AND WE TRACK
	private List<Closeable> closeables = new ArrayList<Closeable>();
	protected final <T extends Closeable> T autoClose(T closeable) {
		closeables.add(0, closeable);
		return closeable;
	}
	
	// TEMPLATE METHOD - CONSTRUCTOR
	public AutoCloser() {
		Throwable pending = null;
		try {
			doWork(); // HOOK CALL
			
		} catch (Throwable t) {
			pending = t;
			
		} finally {
			for (Closeable closeable : closeables) {
				try {
					closeable.close();
				} catch (Throwable t) {
					if (pending == null)
						pending = t;
				}
			}			
			if (pending != null) {
				if (pending instanceof RuntimeException)
					throw (RuntimeException) pending;
				else if (pending instanceof Error)
					throw (Error) pending;
				throw new RuntimeException(pending);
			}
		}
	}
}
