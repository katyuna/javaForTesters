package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

    @Test
    private void testGroupDeletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
        }

}
