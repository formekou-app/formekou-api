package neocode.formekouapi.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@Builder
@Data
public class CreateForm implements Serializable {
    @NonNull
    private String id;
    private String title;
    private String description;
    private boolean isPrivate;
    private Instant openedAt;
    private Instant closedAt;
    private Instant createdAt;
    private boolean allowMultipleChoice;

    @NonNull
    private String color;
}
