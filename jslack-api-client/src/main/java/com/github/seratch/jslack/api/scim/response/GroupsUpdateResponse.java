package com.github.seratch.jslack.api.scim.response;

import com.github.seratch.jslack.api.scim.SCIMApiResponse;
import com.github.seratch.jslack.api.scim.model.Group;
import lombok.Data;

@Data
public class GroupsUpdateResponse extends Group implements SCIMApiResponse {
}
