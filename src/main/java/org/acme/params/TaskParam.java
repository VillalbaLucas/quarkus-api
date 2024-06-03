package org.acme.params;

import org.jboss.resteasy.reactive.RestHeader;
import org.jboss.resteasy.reactive.RestQuery;

public final class TaskParam {
    
    @RestHeader("X-task-ping")
    public String header; 
    
    @RestQuery
    public String priority;
}
