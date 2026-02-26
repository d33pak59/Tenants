-- =========================================
-- V1: Create tenants table
-- =========================================
CREATE TABLE tenants (
                         id              UUID            PRIMARY KEY,
                         tenant_code     VARCHAR(100)    NOT NULL UNIQUE,
                         name            VARCHAR(255)    NOT NULL,
                         tenant_type     VARCHAR(50)     NOT NULL,
                         active          BOOLEAN         DEFAULT TRUE,
                         created_at      TIMESTAMP
);


-- V2: Create tenant_details table
CREATE TABLE tenant_details (
                                id                  UUID            PRIMARY KEY,
                                email               VARCHAR(255),
                                contact_number      VARCHAR(50),
                                registration_number VARCHAR(100),
                                license_number      VARCHAR(100),
                                established_year    INT,
                                founder_name        VARCHAR(255),
                                gst_number          VARCHAR(100),
                                pan_number          VARCHAR(100),
                                website             VARCHAR(255),
                                country             VARCHAR(100),
                                state               VARCHAR(100),
                                city                VARCHAR(100),
                                tenant_id           UUID            NOT NULL UNIQUE,

                                CONSTRAINT fk_tenant_details_tenant
                                    FOREIGN KEY (tenant_id)
                                        REFERENCES tenants(id)
                                        ON DELETE CASCADE
);

-- =========================================
-- Indexes for performance
-- =========================================
CREATE INDEX idx_tenant_code ON tenants(tenant_code);
CREATE INDEX idx_tenant_type ON tenants(tenant_type);
