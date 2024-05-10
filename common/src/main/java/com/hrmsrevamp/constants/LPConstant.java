package com.hrmsrevamp.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Constants to be used in Little Pinger backend.
 */
public final class LPConstant {

  //String Constants

  public static final String LITTLE_PINGER = "little pinger";
  public static final String LITTLE_PINGER_SERVICE =  "little pinger service";
  public static final String SUBJECT =  "email triggering";
  public static final String DEFAULT_PAGE = "0";
  public static final String DEFAULT_PAGE_SIZE = "10";
  public static final String EMAIL = "email";
  public static final String PERMISSION = "permission";
  public static final String USER_REGISTER = "userRegister";
  public static final String NAME = "name";
  public static final String STATUS = "status";

  public static final String LOCAL = "local";
  public static final String QA = "qa";
  public static final String DEV = "dev";

  public static final String PROD = "prod";

  //Cradlepoint device API credential keys.
  public static final String X_ECM_API_ID = "X-ECM-API-ID";
  public static final String X_ECM_API_KEY = "X-ECM-API-KEY";
  public static final String X_CP_API_ID = "X-CP-API-ID";
  public static final String X_CP_API_KEY = "X-CP-API-KEY";
  public static final String CRADLE_POINT_API_URL = "https://www.cradlepointecm.com/api/v2/routers/?name=";
  public static final String ONLINE = "online";
  public static final String OFFLINE = "offline";

  public static final String AZURE_EMAIL_ACCESS_DEV_ENV = "endpoint=https://littlepingerdev-comm-service.unitedstates.communication.azure.com/;accesskey=DkvF3C79sbK/4wVOhXYalQiwdVGxiAYxo3Y3CfAp5O4UfJg9d26NsORTX2kSDmpBnRrP8pyCMrUy1U6/ajnVzQ==";

  public static final String SENDER_ADDRESS_DEV_ENV = "lp-alert@1d233084-5678-45a6-99d1-0740eec223ee.azurecomm.net";

  public static final String AZURE_EMAIL_ACCESS_QA_ENV = "endpoint=https://littlepingerqa-comm-service.unitedstates.communication.azure.com/;accesskey=g/ETDPp0ksLbTSYx4juZrRwjhozHZisB/vKS1JYNU0eTIrxpYYlg2EaLT/ihwnTxPQlmwZ2CqmYVWzMYt5vDbw==";
  public static final String AZURE_EMAIL_ACCESS_PROD_ENV = "endpoint=https://littlepingerprod-comm-service.unitedstates.communication.azure.com/;accesskey=fnZP2mInGJTCuVF9WY7wNYtd+zTgQFAz+k2fBDPz8EqI5dkomTnL29+pcLW0NSq5SqegPmczm+Z1bvpvQKq3Yw==";

  public static final String SENDER_ADDRESS_QA_AND_PROD_ENV = "lp-alert@blueheronsystems.com";

  public static final String MOBILE_CARRIER_DOMAIN_V_TEXT = "@vtext.com";
  public static final String MOBILE_CARRIER_DOMAIN_AT_AND_T = "@txt.att.net";
  public static final String MOBILE_CARRIER_DOMAIN_T_MOBILE = "@tmomail.net";
  public static final String SERVER_TIMEZONE = "Etc/UTC";
  public static final String UTC_TIMEZONE = "UTC";
  public static final String LP_CONTACT_EMAIL_ADDRESS = "lp-contact@blueheronsystems.com";
  public static final String DEVICE_AVAILABILITY_STATUS = "deviceAvailabilityStatus";
  public static final String POLL_TIME = "pollTime";
  public static final String SINCE = "since";
  public static final String AVG = "avg";
  public static final String MIN = "min";
  public static final String MAX = "max";
  public static final String INACTIVE_AT = "inactiveAt";

  public static final String SIGN_IN_LINK_FOR_DEV = "https://lp-dev.blueheronsys.com/signin";

  public static final String SIGN_IN_LINK_FOR_QA = "https://lp-qa.blueheronsys.com/signin";

  public static final String SIGN_IN_LINK_FOR_PROD = "https://lp.blueheronsys.com/signin";

  public static final String LP_DASHBOARD_DEV_URL = "https://lp-dev.blueheronsys.com/dashboard";

  public static final String LP_DASHBOARD_QA_URL = "https://lp-qa.blueheronsys.com/dashboard";

  public static final String LP_DASHBOARD_PROD_URL = "https://lp.blueheronsys.com/dashboard";

  public static final String DEV_IP_ADDRESS = "172.172.229.63";

  public static final String QA_IP_ADDRESS = "172.190.116.19";

  public static final String PROD_IP_ADDRESS = "20.124.86.39";

  public static final String SUBSCRIPTION_TYPE = "subscriptionType";
  public static final String ERROR_MESSAGE = "errorMessage";
  public static final String CANCELED = "canceled";
  public static final String ACTIVE = "active";
  public static final String ALL = "all";
  public static final String TRIAL = "trial";
  public static final String MAX_DEVICES_ALLOWED = "maxDevicesAllowed";
  public static final String PLAN_TYPE = "planType";
  public static final String CURRENCY = "currency";
  public static final String USD = "USD";

  //Number Constants
  public static final int MIN_PASSWORD_LENGTH = 8;
  public static final int NUMBER_SEVEN = 7;
  public static final int FIVE = 5;
  public static final int TEN = 10;
  public static final double ZERO = 0D;
  public static final int USER_ROLE_ID = 2;
  public static final long DAYS_365 = 365;
  public static final int MIN_MOBILE_NUMBER_LENGTH = 10;
  public static final int MAX_MOBILE_NUMBER_LENGTH = 14;

  public static final Map<String, String> TIMEZONE_MAP;

  static {
    Map<String, String> abbreviationMap = new HashMap<>();
    abbreviationMap.put("EST", "America/New_York");
    abbreviationMap.put("CST", "America/Chicago");
    abbreviationMap.put("MST", "America/Denver");
    abbreviationMap.put("PST", "America/Los_Angeles");
    abbreviationMap.put("AST", "America/Anchorage");
    abbreviationMap.put("HST", "America/Adak");
    abbreviationMap.put("IST", "Asia/Calcutta");

    TIMEZONE_MAP = Collections.unmodifiableMap(abbreviationMap);
  }

  private LPConstant() {
    throw new IllegalStateException("Can't create Object of Constant.class");
  }
}
