package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void newAccountShouldNotBeActiveAfterCreation() {
        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
        assertThat(newAccount.isActive()).isFalse();
    }

    @Test
    void newAccountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();
        assertFalse(newAccount.isActive());

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive()).isTrue();
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address).isNull();
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {

        //given
        Address address = new Address("Krakowska", "61c");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);
        assertThat(defaultAddress).isNotNull();
    }

    @Test
    void newlyCreatedAccountShouldNotBeActive() {

        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive());
        assertThat(newAccount.isActive()).isFalse();
    }

}
