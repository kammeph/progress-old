package com.progress.strengthvalue;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.progress.api.ControllerBase;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/strengthvalue")
@Tag(name = "Strength value")
@ApplicationScoped
public class StrengthValueController extends ControllerBase<StrengthValue, StrengthValueDto, Long> {
    
    @Inject
    private StrengthValueService strengthValueService;

    @PostConstruct
    private void init() {
        this.serviceBase = strengthValueService;
    }

    public StrengthValueController() {
        super();
        persistenceDtoClass = StrengthValueDto.class;
    }

    @GET
    @Path("getByUser/{userid}")
    @Produces("application/json")
    @Operation(
        summary = "Get by user id",
        description = "Get a list of strength values by user id")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "Strength values are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "Strength values not found")
        }
    )
    public Response getByTotalStrengthValue(@PathParam("userid") Long userid) {
        var entities = strengthValueService.getByUser(userid);
        if (entities != null && entities.size() > 0)
            return Response.ok(mapList(entities, persistenceDtoClass)).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}