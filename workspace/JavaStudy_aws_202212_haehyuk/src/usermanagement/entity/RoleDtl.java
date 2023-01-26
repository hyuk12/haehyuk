package usermanagement.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDtl {
    private int roleDtlId;
    private int roleId;
    private int userId;

    private RoleMst roleMst;

}
