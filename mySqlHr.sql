
CREATE TABLE  hr.Candidate (
  idCandidate INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL unique,
  dateOfBirth DATE NULL,
  contactNumber VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  PRIMARY KEY (idCandidate)
  );
  
  CREATE TABLE  hr.Skills (
  idSkill INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL unique,
  PRIMARY KEY (idSkill)
  );
  
  
  CREATE TABLE  hr.CandidateSkills (
  idCandidate INT NOT NULL,
  idSkill INT NOT NULL,
  PRIMARY KEY (idCandidate,idSkill),
  INDEX fk_CandidateSkills_Skill_idx (idSkill ASC),
  CONSTRAINT fk_CandidateSkills_Candidate
    FOREIGN KEY (idCandidate)
    REFERENCES hr.Candidate (idCandidate)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_CandidateSkills_Skill
    FOREIGN KEY (idSkill)
    REFERENCES hr.Skills (idSkill)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
  )
  
