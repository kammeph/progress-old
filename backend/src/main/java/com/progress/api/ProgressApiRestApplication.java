package com.progress.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

/**
 *
 */
@ApplicationPath("/api")
@OpenAPIDefinition(
    info = @Info(
        title="PROGRESS", 
        version="2.0", 
        description="API for the PROGRESS powerlifting programming tool", 
        contact = @Contact(
            name="Philipp Kammerer"))
)

public class ProgressApiRestApplication extends Application {
    
}
