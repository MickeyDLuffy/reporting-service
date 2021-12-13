-- Create schema

CREATE TABLE IF NOT EXISTS report (
                                      id UUID NOT NULL PRIMARY KEY,
                                      details JSONB,
                                      description TEXT,
                                      event_type VARCHAR(100),
    event_timestamp TIMESTAMPTZ
    );

-- Create indexes
-- CREATE UNIQUE INDEX priority_name_idx ON priority(name);


