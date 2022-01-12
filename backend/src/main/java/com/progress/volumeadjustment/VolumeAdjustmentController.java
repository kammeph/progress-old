package com.progress.volumeadjustment;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import jakarta.persistence.NonUniqueResultException;

@Path("/volumeadjustment")
@Tag(name = "Volume adjustment")
@ApplicationScoped
public class VolumeAdjustmentController extends ControllerBase<VolumeAdjustment, VolumeAdjustmentDto, Long> {

    @Inject
    private VolumeAdjustmentService volumeAdjustmentService;

    @PostConstruct
    private void init() {
        this.serviceBase = volumeAdjustmentService;
    }

    public VolumeAdjustmentController() {
        super();
        this.persistenceDtoClass = VolumeAdjustmentDto.class;
    }

    @GET
    @Path("getByProperty/{property}")
    @Produces("application/json")
    @Operation(summary = "Get by volume adjustments by property", description = "Gets a list of volume adjustments for a specific property")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Volume adjustments are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "Volume adjustments not found") })
    public Response getByGroup(@PathParam("property") Integer property) {
        var volumeAdjustment = volumeAdjustmentService.getByProperty(property);
        if (volumeAdjustment != null && volumeAdjustment.size() > 0)
            return Response.ok(mapList(volumeAdjustment, VolumeAdjustmentDto.class)).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("getByGender/{gender}")
    @Produces("application/json")
    @Operation(summary = "Get by volume adjustments by gender", description = "Gets a list of volume adjustments for a specific gender")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Volume adjustments are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "Volume adjustments not found") })
    public Response getByGender(@PathParam("gender") Integer gender) {
        var volumeAdjustment = volumeAdjustmentService.getByGender(gender);
        if (volumeAdjustment != null && volumeAdjustment.size() > 0)
            return Response.ok(mapList(volumeAdjustment, VolumeAdjustmentDto.class)).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("getByUser/{userid}")
    @Produces("application/json")
    @Operation(summary = "Get by user", description = "Gets a list of volume adjustments for a specific user id")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Volume adjustments are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "Volume adjustments not found") })
    public Response getByUser(@PathParam("userid") Long userid) {
        var volumeAdjustment = volumeAdjustmentService.getByUser(userid);
        if (volumeAdjustment != null && volumeAdjustment.size() > 0)
            return Response.ok(mapList(volumeAdjustment, VolumeAdjustmentDto.class)).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("addUser/{id}/{userid}")
    @Operation(summary = "Add user", description = "Add user to volume adjustment")
    @APIResponses({ @APIResponse(responseCode = "200", description = "User added"),
            @APIResponse(responseCode = "401", description = "User adding failed") })
    public Response addUser(@PathParam("id") Long id, @PathParam("userid") Long userid) {
        volumeAdjustmentService.addUser(id, userid);
        return Response.ok().build();
    }

    @POST
    @Path("removeUser/{id}/{userid}")
    @Operation(summary = "Remove user", description = "Remove user from volume adjustment")
    @APIResponses({ @APIResponse(responseCode = "200", description = "User removed"),
            @APIResponse(responseCode = "401", description = "User removing failed") })
    public Response deleteUser(@PathParam("id") Long id, @PathParam("userid") Long userid) {
        volumeAdjustmentService.removeUser(id, userid);
        return Response.ok().build();
    }

    @GET
    @Path("getVolumeAdjustmentSelections/{userid}/{gender}")
    @Produces("application/json")
    @Operation(summary = "Get volume adjustment selections", description = "Get selections of volume adjustments")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Volume adjustment selections are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "409", description = "Volume adjustment selections conflict") })
    public Response getVolumeAdjustmentSelection(@PathParam("userid") Long userid,
            @PathParam("gender") Integer gender) {

        List<VolumeAdjustmentSelectionDto> volumeAdjustmentSelectionDtos = new ArrayList<>();
        for (var volumeProperty : VolumeProperty.class.getEnumConstants()) {
            VolumeAdjustment volumeAdjustment = null;
            try {
                volumeAdjustment = volumeAdjustmentService.getByUserAndProperty(userid, volumeProperty.ordinal());
            } catch (NonUniqueResultException e) {
                return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
            }

            var volumeAdjustments = volumeAdjustmentService.getByGenderAndProperty(gender, volumeProperty.ordinal());

            if (volumeAdjustments != null && volumeAdjustments.size() > 0) {
                var volumeAdjustmentSelectionDto = new VolumeAdjustmentSelectionDto();
                if (volumeAdjustment != null)
                    volumeAdjustmentSelectionDto.setSelectedVolumeAdjustment(this.mapper.map(volumeAdjustment, VolumeAdjustmentDto.class));
                volumeAdjustmentSelectionDto.setVolumeProperty(volumeAdjustments.get(0).getVolumeProperty().toString());
                volumeAdjustmentSelectionDto.setVolumeAdjustments(mapList(volumeAdjustments, VolumeAdjustmentDto.class));
                volumeAdjustmentSelectionDtos.add(volumeAdjustmentSelectionDto);
            }
        }

        return Response.ok(volumeAdjustmentSelectionDtos).build();
    }
}
