# Java Chatbot & CV Analyzer

A Java console chatbot with a built-in CV (resume) analyzer, built with Maven,
Apache OpenNLP and Apache PDFBox.

## Status
🚧 Work in progress — actively adding features.

## Features
- **Chatbot:** Console chatbot with simple keyword-based sentiment detection
  (OpenNLP tokenizer).
- **CV Analyzer:** Reads a PDF resume, splits it into sections
  (Profile, Education, Skills, ...), and reports missing and weak sections.

## Roadmap
- Store analysis results in PostgreSQL
- Run the chatbot as a network server (TCP / HTTP)
- Containerize with Docker and deploy to AWS

## Tech Stack
Java 17, Maven, Apache OpenNLP, Apache PDFBox

## How to Run
Requirements: Java 17+ and Maven.

```bash
mvn clean compile
```

Run the chatbot:

```bash
mvn exec:java "-Dexec.mainClass=chatbot.main"
```

Run the CV analyzer:

```bash
mvn exec:java "-Dexec.mainClass=chatbot.cv.CvReader" "-Dexec.args=path/to/cv.pdf"
```

## What I'm Learning
NLP libraries, PDF processing, Maven project structure,
and iterative feature development.

## Copyright
© 2026 Yağmur Erocağı. All rights reserved.

This code is shared for viewing purposes only. You may not copy, modify,
or distribute it without written permission.
