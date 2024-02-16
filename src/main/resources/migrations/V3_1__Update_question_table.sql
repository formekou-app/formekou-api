DO $$
    BEGIN
        IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'question' AND column_name = 'type') THEN
            ALTER TABLE "question" DROP COLUMN type;
        END IF;
    END $$;

DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'question' AND column_name = 'type') THEN
            ALTER TABLE "question" ADD COLUMN type varchar(255) NOT NULL;
        END IF;
    END $$;