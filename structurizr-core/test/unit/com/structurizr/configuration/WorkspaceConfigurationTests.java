package com.structurizr.configuration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WorkspaceConfigurationTests {

    @Test
    public void test_addUser_ThrowsAnException_WhenANullUsernameIsSpecified() {
        try {
            WorkspaceConfiguration configuration = new WorkspaceConfiguration();
            configuration.addUser(null, Role.ReadWrite);
            fail();
        } catch (IllegalArgumentException iae) {
            assertEquals("A username must be specified.", iae.getMessage());
        }
    }

    @Test
    public void test_addUser_ThrowsAnException_WhenAnEmptyUsernameIsSpecified() {
        try {
            WorkspaceConfiguration configuration = new WorkspaceConfiguration();
            configuration.addUser(" ", Role.ReadWrite);
            fail();
        } catch (IllegalArgumentException iae) {
            assertEquals("A username must be specified.", iae.getMessage());
        }
    }

    @Test
    public void test_addUser_ThrowsAnException_WhenANullRoleIsSpecified() {
        try {
            WorkspaceConfiguration configuration = new WorkspaceConfiguration();
            configuration.addUser("user@domain.com", null);
            fail();
        } catch (IllegalArgumentException iae) {
            assertEquals("A role must be specified.", iae.getMessage());
        }
    }

    @Test
    public void test_addUser_AddsAUser() {
        WorkspaceConfiguration configuration = new WorkspaceConfiguration();
        configuration.addUser("user@domain.com", Role.ReadOnly);

        assertEquals(1, configuration.getUsers().size());
        assertEquals("user@domain.com", configuration.getUsers().iterator().next().getUsername());
        assertEquals(Role.ReadOnly, configuration.getUsers().iterator().next().getRole());
    }

}