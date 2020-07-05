-- -----------------------------------------------------
-- Schema "customer"
-- -----------------------------------------------------
CREATE SCHEMA "customer";

-- -----------------------------------------------------
-- Table "customer"."gender"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "customer"."gender"
(
    "id"          UUID          NOT NULL
        CONSTRAINT "pk_gender" PRIMARY KEY,
    "name"        VARCHAR(50)   NOT NULL,
    "description" VARCHAR(2000) NOT NULL,
    CONSTRAINT "un_gender_name" UNIQUE ("name")
);


-- -----------------------------------------------------
-- Table "customer"."customer"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "customer"."customer"
(
    "id"                UUID           NOT NULL
        CONSTRAINT "pk_customer" PRIMARY KEY,
    "first_name"        VARCHAR(150)   NOT NULL,
    "last_name"         VARCHAR(150)   NOT NULL,
    "document_number"   VARCHAR(50)    NULL,
    "tax_id"            VARCHAR(50)    NOT NULL,
    "birth_date"        DATE           NULL,
    "main_email"        VARCHAR(250)   NOT NULL,
    "phone_number"      VARCHAR(50)    NOT NULL,
    "is_whatsapp"       BOOLEAN        NULL,
    "created_at"        TIMESTAMPTZ(6) NOT NULL,
    "is_active"         BOOLEAN        NOT NULL,
    "activation_date"   TIMESTAMPTZ(6) NULL,
    "activation_token"  VARCHAR(250)   NOT NULL,
    "biological_gender" VARCHAR(25)    NOT NULL,
    "gender_id"         UUID           NOT NULL
        CONSTRAINT "fk_customer_gender"
            REFERENCES "customer"."gender" ("id")
            ON DELETE RESTRICT,
    CONSTRAINT "un_customer_tax_id" UNIQUE ("tax_id"),
    CONSTRAINT "un_customer_main_email" UNIQUE ("main_email"),
    CONSTRAINT "un_customer_phone_number" UNIQUE ("phone_number", "is_active")
);

CREATE INDEX "idx_customer_first_name" ON "customer"."customer" ("first_name");
CREATE INDEX "idx_customer_last_name" ON "customer"."customer" ("last_name");

-- -----------------------------------------------------
-- Table "customer"."contact_type"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "customer"."contact_type"
(
    "id"   UUID        NOT NULL
        CONSTRAINT "pk_contact_type" PRIMARY KEY,
    "name" VARCHAR(50) NOT NULL,
    CONSTRAINT "un_contact_type_name" UNIQUE ("name")
);


-- -----------------------------------------------------
-- Table "customer"."contact"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "customer"."contact"
(
    "id"              UUID         NOT NULL
        CONSTRAINT "pk_contact" PRIMARY KEY,
    "description"     VARCHAR(250) NOT NULL,
    "observation"     VARCHAR(250) NULL,
    "contact_type_id" UUID         NOT NULL
        CONSTRAINT "fk_contact_contact_type"
            REFERENCES "customer"."contact_type" ("id")
            ON DELETE RESTRICT,
    "customer_id"     UUID         NOT NULL
        CONSTRAINT "fk_contact_customer"
            REFERENCES "customer"."customer" ("id")
            ON DELETE RESTRICT
);

-- -----------------------------------------------------
-- Schema "customer"
-- -----------------------------------------------------
CREATE SCHEMA "location";

-- -----------------------------------------------------
-- Table "location"."state"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "location"."state"
(
    "id"      UUID         NOT NULL
        CONSTRAINT "pk_state" PRIMARY KEY,
    "name"    VARCHAR(200) NOT NULL,
    "acronym" VARCHAR(10)  NOT NULL,
    CONSTRAINT "un_state_name" UNIQUE ("name"),
    CONSTRAINT "un_state_acronym" UNIQUE ("acronym")
);

-- -----------------------------------------------------
-- Table "location"."city"
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS "location"."city"
(
    "id"        UUID            NOT NULL
        CONSTRAINT "pk_city" PRIMARY KEY,
    "name"      VARCHAR(250)    NOT NULL,
    "latitude"  DECIMAL(25, 20) NOT NULL,
    "longitude" DECIMAL(25, 20) NOT NULL,
    "ibge"      VARCHAR(50)     NOT NULL,
    "state_id"  UUID            NOT NULL
        CONSTRAINT "fk_city_state"
            REFERENCES "location"."state" ("id")
            ON DELETE RESTRICT
);

-- -----------------------------------------------------
-- Table "location"."address"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "location"."address"
(
    "id"          UUID            NOT NULL
        CONSTRAINT "pk_address" PRIMARY KEY,
    "street"      VARCHAR(250)    NOT NULL,
    "number"      VARCHAR(25)     NOT NULL,
    "zipcode"     VARCHAR(25)     NOT NULL,
    "complement"  VARCHAR(50)     NULL,
    "latitude"    DECIMAL(25, 20) NULL,
    "longitude"   DECIMAL(25, 20) NULL,
    "customer_id" UUID            NOT NULL
        CONSTRAINT "fk_address_customer"
            REFERENCES "customer"."customer" ("id")
            ON DELETE RESTRICT,
    "city_id"     UUID            NOT NULL
        CONSTRAINT "fk_address_city"
            REFERENCES "location"."city" ("id")
            ON DELETE RESTRICT
);
