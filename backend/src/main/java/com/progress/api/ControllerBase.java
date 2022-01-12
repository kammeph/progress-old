package com.progress.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.progress.db.ServiceBase;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.modelmapper.ModelMapper;

public class ControllerBase<T, TDto, ID> {
    
    protected ServiceBase<T, ID> serviceBase;
    
    @Inject
    protected ModelMapper mapper;

    protected Class<TDto> persistenceDtoClass;

    protected List<TDto> mapList(List<T> source, Class<TDto> targetClass) {
        return source
            .stream()
            .map(element -> mapper.map(element, targetClass))
            .collect(Collectors.toList());
    }

    @GET
    @Produces("application/json")
    @Operation(
        summary = "Get all",
        description = "Get all items of a table")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "All items are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "No items found")
        }
    )
    public Response getAll() {
        List<T> entities = serviceBase.getAll();
        List<TDto> dtos = mapList(entities, persistenceDtoClass);
        if (dtos != null)
            return Response.ok().entity(dtos).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    @Operation(
        summary = "Get",
        description = "Get a specific item by id")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "Item is returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "Item not found")
        }
    )
    public Response get(@PathParam("id") ID id) {
        T entity = serviceBase.get(id);
        TDto dto = mapper.map(entity, persistenceDtoClass);
        if (dto != null)
            return Response.ok().entity(dto).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Create",
        description = "Create a new item")
    @APIResponses(
        {
            @APIResponse(responseCode = "201", description = "New item was created"),
            @APIResponse(responseCode = "400", description = "Item not found")
        }
    )
    public Response create(TDto dto) {
        T entity = mapper.map(dto, serviceBase.getPersistenceClass());
        T created = serviceBase.create(entity);
        if (created != null)
            return Response.status(Response.Status.CREATED).entity(created).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Update",
        description = "Update a specific item")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "Item was updated"),
            @APIResponse(responseCode = "400", description = "Bad Request")
        }
    )
    public Response update(@PathParam("id") ID id, TDto dto) throws IllegalArgumentException, IllegalAccessException {
        T entity = mapper.map(dto, serviceBase.getPersistenceClass());
        Boolean updated = serviceBase.update(id, entity);
        if (updated)
            return Response.ok().build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(
        summary = "Delete",
        description = "Delete a specific item")
    @APIResponses(
        {
            @APIResponse(responseCode = "204", description = "Item was deleted"),
            @APIResponse(responseCode = "404", description = "Item not found")
        }
    )
    public Response delete(@PathParam("id") ID id) {
        Boolean deleted = serviceBase.delete(id);
        if (deleted)
            return Response.noContent().build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
