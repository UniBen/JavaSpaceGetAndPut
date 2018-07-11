A JavaSpaces demo

Gary Allen, University of Huddersfield.

The Putter writes string objects into a space, the Getter retrieves them again.

Updated to use Apache River 3.0

NOTE - if the run configurations are not imported correctly, the following MUST be passed as VM args to both Getter and Putter:

    -Djava.security.policy=policy.all -Djava.rmi.server.useCodebaseOnly=false

