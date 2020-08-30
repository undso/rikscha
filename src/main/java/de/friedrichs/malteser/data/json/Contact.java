package de.friedrichs.malteser.data.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AFR
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact implements Serializable {

    private static final long serialVersionUID = 2158041959953452266L;

    @JsonProperty("contact_id")
    private String contactId;
    @JsonProperty("contact_type")
    private String contactType;
    @JsonProperty("contact_sub_type")
    private List<String> contactSubType = null;
    @JsonProperty("sort_name")
    private String sortName;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("do_not_email")
    private String doNotEmail;
    @JsonProperty("do_not_phone")
    private String doNotPhone;
    @JsonProperty("do_not_mail")
    private String doNotMail;
    @JsonProperty("do_not_sms")
    private String doNotSms;
    @JsonProperty("do_not_trade")
    private String doNotTrade;
    @JsonProperty("is_opt_out")
    private String isOptOut;
    @JsonProperty("legal_identifier")
    private String legalIdentifier;
    @JsonProperty("external_identifier")
    private String externalIdentifier;
    @JsonProperty("nick_name")
    private String nickName;
    @JsonProperty("legal_name")
    private String legalName;
    @JsonProperty("image_URL")
    private String imageURL;
    @JsonProperty("preferred_communication_method")
    private Object preferredCommunicationMethod;
    @JsonProperty("preferred_language")
    private String preferredLanguage;
    @JsonProperty("preferred_mail_format")
    private String preferredMailFormat;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("prefix_id")
    private String prefixId;
    @JsonProperty("suffix_id")
    private String suffixId;
    @JsonProperty("formal_title")
    private String formalTitle;
    @JsonProperty("communication_style_id")
    private String communicationStyleId;
    @JsonProperty("job_title")
    private String jobTitle;
    @JsonProperty("gender_id")
    private String genderId;
    @JsonProperty("birth_date")
    private String birthDate;
    @JsonProperty("is_deceased")
    private String isDeceased;
    @JsonProperty("deceased_date")
    private String deceasedDate;
    @JsonProperty("household_name")
    private String householdName;
    @JsonProperty("organization_name")
    private String organizationName;
    @JsonProperty("sic_code")
    private String sicCode;
    @JsonProperty("contact_is_deleted")
    private String contactIsDeleted;
    @JsonProperty("current_employer")
    private String currentEmployer;
    @JsonProperty("address_id")
    private String addressId;
    @JsonProperty("street_address")
    private String streetAddress;
    @JsonProperty("supplemental_address_1")
    private String supplementalAddress1;
    @JsonProperty("supplemental_address_2")
    private String supplementalAddress2;
    @JsonProperty("supplemental_address_3")
    private String supplementalAddress3;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postal_code_suffix")
    private String postalCodeSuffix;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("geo_code_1")
    private String geoCode1;
    @JsonProperty("geo_code_2")
    private String geoCode2;
    @JsonProperty("state_province_id")
    private String stateProvinceId;
    @JsonProperty("country_id")
    private String countryId;
    @JsonProperty("phone_id")
    private String phoneId;
    @JsonProperty("phone_type_id")
    private String phoneTypeId;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email_id")
    private String emailId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("on_hold")
    private String onHold;
    @JsonProperty("im_id")
    private String imId;
    @JsonProperty("provider_id")
    private String providerId;
    @JsonProperty("im")
    private String im;
    @JsonProperty("worldregion_id")
    private String worldregionId;
    @JsonProperty("world_region")
    private String worldRegion;
    @JsonProperty("civicrm_value_meta_informat_7_id")
    private String civicrmValueMetaInformat7Id;
    @JsonProperty("custom_146")
    private String custom146;
    @JsonProperty("languages")
    private String languages;
    @JsonProperty("individual_prefix")
    private String individualPrefix;
    @JsonProperty("individual_suffix")
    private String individualSuffix;
    @JsonProperty("communication_style")
    private String communicationStyle;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("state_province_name")
    private String stateProvinceName;
    @JsonProperty("state_province")
    private String stateProvince;
    @JsonProperty("country")
    private String country;
    @JsonProperty("id")
    private String id;
    @JsonProperty("api.Phone.get")
    private PhonesResult phonesResult;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public Contact() {
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public List<String> getContactSubType() {
        return contactSubType;
    }

    public void setContactSubType(List<String> contactSubType) {
        this.contactSubType = contactSubType;
    }

    public String getDoNotEmail() {
        return doNotEmail;
    }

    public void setDoNotEmail(String doNotEmail) {
        this.doNotEmail = doNotEmail;
    }

    public String getDoNotPhone() {
        return doNotPhone;
    }

    public void setDoNotPhone(String doNotPhone) {
        this.doNotPhone = doNotPhone;
    }

    public String getDoNotMail() {
        return doNotMail;
    }

    public void setDoNotMail(String doNotMail) {
        this.doNotMail = doNotMail;
    }

    public String getDoNotSms() {
        return doNotSms;
    }

    public void setDoNotSms(String doNotSms) {
        this.doNotSms = doNotSms;
    }

    public String getDoNotTrade() {
        return doNotTrade;
    }

    public void setDoNotTrade(String doNotTrade) {
        this.doNotTrade = doNotTrade;
    }

    public String getIsOptOut() {
        return isOptOut;
    }

    public void setIsOptOut(String isOptOut) {
        this.isOptOut = isOptOut;
    }

    public String getLegalIdentifier() {
        return legalIdentifier;
    }

    public void setLegalIdentifier(String legalIdentifier) {
        this.legalIdentifier = legalIdentifier;
    }

    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Object getPreferredCommunicationMethod() {
        return preferredCommunicationMethod;
    }

    public void setPreferredCommunicationMethod(Object preferredCommunicationMethod) {
        this.preferredCommunicationMethod = preferredCommunicationMethod;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getPreferredMailFormat() {
        return preferredMailFormat;
    }

    public void setPreferredMailFormat(String preferredMailFormat) {
        this.preferredMailFormat = preferredMailFormat;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(String prefixId) {
        this.prefixId = prefixId;
    }

    public String getSuffixId() {
        return suffixId;
    }

    public void setSuffixId(String suffixId) {
        this.suffixId = suffixId;
    }

    public String getFormalTitle() {
        return formalTitle;
    }

    public void setFormalTitle(String formalTitle) {
        this.formalTitle = formalTitle;
    }

    public String getCommunicationStyleId() {
        return communicationStyleId;
    }

    public void setCommunicationStyleId(String communicationStyleId) {
        this.communicationStyleId = communicationStyleId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIsDeceased() {
        return isDeceased;
    }

    public void setIsDeceased(String isDeceased) {
        this.isDeceased = isDeceased;
    }

    public String getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(String deceasedDate) {
        this.deceasedDate = deceasedDate;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getSicCode() {
        return sicCode;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    public String getContactIsDeleted() {
        return contactIsDeleted;
    }

    public void setContactIsDeleted(String contactIsDeleted) {
        this.contactIsDeleted = contactIsDeleted;
    }

    public String getCurrentEmployer() {
        return currentEmployer;
    }

    public void setCurrentEmployer(String currentEmployer) {
        this.currentEmployer = currentEmployer;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSupplementalAddress1() {
        return supplementalAddress1;
    }

    public void setSupplementalAddress1(String supplementalAddress1) {
        this.supplementalAddress1 = supplementalAddress1;
    }

    public String getSupplementalAddress2() {
        return supplementalAddress2;
    }

    public void setSupplementalAddress2(String supplementalAddress2) {
        this.supplementalAddress2 = supplementalAddress2;
    }

    public String getSupplementalAddress3() {
        return supplementalAddress3;
    }

    public void setSupplementalAddress3(String supplementalAddress3) {
        this.supplementalAddress3 = supplementalAddress3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCodeSuffix() {
        return postalCodeSuffix;
    }

    public void setPostalCodeSuffix(String postalCodeSuffix) {
        this.postalCodeSuffix = postalCodeSuffix;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getGeoCode1() {
        return geoCode1;
    }

    public void setGeoCode1(String geoCode1) {
        this.geoCode1 = geoCode1;
    }

    public String getGeoCode2() {
        return geoCode2;
    }

    public void setGeoCode2(String geoCode2) {
        this.geoCode2 = geoCode2;
    }

    public String getStateProvinceId() {
        return stateProvinceId;
    }

    public void setStateProvinceId(String stateProvinceId) {
        this.stateProvinceId = stateProvinceId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneTypeId() {
        return phoneTypeId;
    }

    public void setPhoneTypeId(String phoneTypeId) {
        this.phoneTypeId = phoneTypeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOnHold() {
        return onHold;
    }

    public void setOnHold(String onHold) {
        this.onHold = onHold;
    }

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getWorldregionId() {
        return worldregionId;
    }

    public void setWorldregionId(String worldregionId) {
        this.worldregionId = worldregionId;
    }

    public String getWorldRegion() {
        return worldRegion;
    }

    public void setWorldRegion(String worldRegion) {
        this.worldRegion = worldRegion;
    }

    public String getCivicrmValueMetaInformat7Id() {
        return civicrmValueMetaInformat7Id;
    }

    public void setCivicrmValueMetaInformat7Id(String civicrmValueMetaInformat7Id) {
        this.civicrmValueMetaInformat7Id = civicrmValueMetaInformat7Id;
    }

    public String getCustom146() {
        return custom146;
    }

    public void setCustom146(String custom146) {
        this.custom146 = custom146;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getIndividualPrefix() {
        return individualPrefix;
    }

    public void setIndividualPrefix(String individualPrefix) {
        this.individualPrefix = individualPrefix;
    }

    public String getIndividualSuffix() {
        return individualSuffix;
    }

    public void setIndividualSuffix(String individualSuffix) {
        this.individualSuffix = individualSuffix;
    }

    public String getCommunicationStyle() {
        return communicationStyle;
    }

    public void setCommunicationStyle(String communicationStyle) {
        this.communicationStyle = communicationStyle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStateProvinceName() {
        return stateProvinceName;
    }

    public void setStateProvinceName(String stateProvinceName) {
        this.stateProvinceName = stateProvinceName;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PhonesResult getPhonesResult() {
        return phonesResult;
    }

    public void setPhonesResult(PhonesResult phonesResult) {
        this.phonesResult = phonesResult;
    }

    
    
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @Override
    public String toString() {
        return "Contact{" + "contactId=" + contactId + ", sortName=" + sortName + ", displayName=" + displayName + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}
