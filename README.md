# AIDL-Basics
Basic AIDL example

#How it works?
IAdditionInterface.aidl is the aidl interface defined here for IPC which returns result of addition of two numbers. On getting onServiceConnected() we parse the instance of the interface with the helper method IAdditionInterface.Stub.asInterface((IBinder)service) and then call the method with the parameters.
Note: Create a package for the AIDL file separately and use for both client and server the same package.

#How to use?
Just install AIDLservice and then install AIDLactivity. Launch AIDLactivity and see for tag "Saurav".


