/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.ui;

import java.io.Serializable;

import org.eclipse.hawkbit.im.authentication.PermissionService;
import org.eclipse.hawkbit.im.authentication.SpPermission;

/**
 * Bean which contains all SP permissions.
 *
 */
public class SpPermissionChecker implements Serializable {
    private static final long serialVersionUID = 2757865286212875704L;

    protected transient PermissionService permissionService;

    protected SpPermissionChecker(final PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * Gets the SP monitor View Permission.
     * 
     * @return SYSTEM_MONITOR boolean value
     */
    public boolean hasSpMonitorViewPermission() {
        return permissionService.hasPermission(SpPermission.SYSTEM_MONITOR);
    }

    /**
     * Gets the SP diagnosis retrieval Permission.
     * 
     * @return SYSTEM_DIAG boolean value
     */
    public boolean hasSpdiagnosisViewPermission() {
        return permissionService.hasPermission(SpPermission.SYSTEM_DIAG);
    }

    /**
     * Gets the SP read Target & Dist Permission.
     * 
     * @return TARGET_REPOSITORY_READ boolean value
     */
    public boolean hasTargetAndRepositoryReadPermission() {
        return hasTargetReadPermission() && hasReadRepositoryPermission();
    }

    /**
     * Gets the SP read Target Permission.
     * 
     * @return READ_TARGET boolean value
     */
    public boolean hasTargetReadPermission() {
        return permissionService.hasPermission(SpPermission.READ_TARGET);
    }

    /**
     * Gets the SP create Target Permission.
     * 
     * @return READ_TARGET boolean value
     */
    public boolean hasCreateTargetPermission() {
        return hasTargetReadPermission() && permissionService.hasPermission(SpPermission.CREATE_TARGET);
    }

    /**
     * Gets the SP update Target Permission.
     * 
     * @return READ_TARGET boolean value
     */
    public boolean hasUpdateTargetPermission() {
        return hasTargetReadPermission() && permissionService.hasPermission(SpPermission.UPDATE_TARGET);
    }

    /**
     * Gets the SP delete Target Permission.
     * 
     * @return READ_TARGET boolean value
     */
    public boolean hasDeleteTargetPermission() {
        return hasTargetReadPermission() && permissionService.hasPermission(SpPermission.DELETE_TARGET);
    }

    /**
     * Gets the SP READ Repository Permission.
     * 
     * @return READ_REPOSITORY boolean value
     */
    public boolean hasReadRepositoryPermission() {
        return permissionService.hasPermission(SpPermission.READ_REPOSITORY);
    }

    /**
     * Gets the SP create Repository Permission.
     * 
     * @return CREATE_REPOSITORY boolean value
     */
    public boolean hasCreateRepositoryPermission() {
        return hasReadRepositoryPermission() && permissionService.hasPermission(SpPermission.CREATE_REPOSITORY);
    }

    /**
     * Gets the SP update Repository Permission.
     * 
     * @return UPDATE_REPOSITORY boolean value
     */
    public boolean hasUpdateRepositoryPermission() {
        return hasReadRepositoryPermission() && permissionService.hasPermission(SpPermission.UPDATE_REPOSITORY);
    }

    /**
     * Gets the SP delete Repository Permission.
     * 
     * @return DELETE_REPOSITORY boolean value
     */
    public boolean hasDeleteRepositoryPermission() {
        return hasReadRepositoryPermission() && permissionService.hasPermission(SpPermission.DELETE_REPOSITORY);
    }

    /**
     * Gets the SP rollout create permission.
     * 
     * @return permission for rollout update
     */
    public boolean hasRolloutUpdatePermission() {
        return hasUpdateTargetPermission() && hasReadRepositoryPermission()
                && permissionService.hasPermission(SpPermission.ROLLOUT_MANAGEMENT);
    }

    /**
     * Gets the SP rollout create permission.
     * 
     * @return permission for rollout create
     */
    public boolean hasRolloutCreatePermission() {
        return hasUpdateTargetPermission() && hasReadRepositoryPermission()
                && permissionService.hasPermission(SpPermission.ROLLOUT_MANAGEMENT);
    }

    /**
     * 
     * Gets the SP rollout read permission.
     * 
     * @return Gets the SP rollout read permission.
     */
    public boolean hasRolloutReadPermission() {
        return permissionService.hasPermission(SpPermission.ROLLOUT_MANAGEMENT);
    }

    /**
     * Gets the SP rollout targets read permission.
     * 
     * @return permission to read rollout targets
     */
    public boolean hasRolloutTargetsReadPermission() {
        return hasTargetReadPermission() && permissionService.hasPermission(SpPermission.ROLLOUT_MANAGEMENT);
    }
}
