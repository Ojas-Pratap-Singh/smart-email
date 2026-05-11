# IntelliMail — AI-Powered Email Response Platform

IntelliMail is an AI-powered email reply generation platform that helps users generate professional and context-aware email responses using Google's Gemini API.

The project consists of:
- Spring Boot Backend API
- React Frontend Application
- Gmail Chrome Extension

Users can generate AI-powered replies with customizable tones such as professional, casual, and friendly directly inside Gmail or through a web interface.

---

# Features

- AI-generated email replies using Gemini API
- Tone-based response customization
- Spring Boot REST API backend
- React frontend interface
- Gmail Chrome Extension integration
- Real-time API communication using WebClient
- Context-aware email generation
- Dynamic Gmail compose window integration
- Clean layered backend architecture

---

# Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring Web
- Spring WebFlux (WebClient)
- Maven
- Lombok
- Jackson ObjectMapper

## Frontend
- React.js
- Vite
- Material UI
- Axios

## Browser Extension
- Chrome Extension (Manifest V3)
- JavaScript
- MutationObserver API

## AI Integration
- Google Gemini API

---

# Project Structure

```text
IntelliMail/
│
├── backend/              # Spring Boot Backend
├── frontend/             # React Frontend
├── chrome-extension/     # Gmail Chrome Extension
└── README.md
```

---

# How It Works

1. User enters email content or opens Gmail reply window.
2. Frontend/Chrome Extension sends request to Spring Boot backend.
3. Backend dynamically constructs AI prompt.
4. Spring WebClient communicates with Gemini API.
5. Gemini API generates context-aware email reply.
6. Backend parses response JSON using Jackson.
7. Generated response is returned to frontend/extension.
8. Chrome Extension injects AI reply directly into Gmail compose box.

---

# Backend Flow

```text
Controller -> Service -> Gemini API -> Response Parsing -> Client
```

---

# API Endpoint

## Generate Email Reply

### POST
```http
/api/email/generate
```

### Request Body

```json
{
  "emailContent": "Thank you for reaching out regarding the meeting.",
  "tone": "professional"
}
```

### Response

```json
{
  "reply": "Thank you for your email. I appreciate your message..."
}
```

---

# Prompt Generation

The backend dynamically creates prompts like:

```text
Generate a professional email reply for the following email content.
Please don't generate a subject line.

Original Email:
<email_content>
```

The tone can be customized dynamically.

---

# Gmail Chrome Extension

The Chrome Extension integrates directly into Gmail UI.

### Features
- Injects "AI Reply" button into Gmail compose window
- Reads email content automatically
- Sends request to backend API
- Inserts generated AI reply directly into compose box

### Technologies Used
- Manifest V3
- Content Scripts
- MutationObserver API

---

# Frontend Features

- User-friendly UI built using React + Material UI
- Multi-line email input
- Tone selection dropdown
- Loading indicators
- Error handling
- Copy generated reply functionality

---

# Setup Instructions

## 1. Clone Repository

```bash
git clone https://github.com/your-username/intellimail.git
cd intellimail
```

---

# Backend Setup

## Navigate to Backend

```bash
cd backend
```

## Add Environment Variables

Configure environment variables in IntelliJ:

```env
GEMINI_API_URL=your_gemini_api_url
GEMINI_API_KEY=your_api_key
```

## Install Dependencies

```bash
mvn clean install
```

## Run Backend

```bash
mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

# Frontend Setup

## Navigate to Frontend

```bash
cd frontend
```

## Install Dependencies

```bash
npm install
```

## Run Frontend

```bash
npm run dev
```

Frontend runs on:

```text
http://localhost:5173
```

---

# Chrome Extension Setup

1. Open Chrome
2. Go to:

```text
chrome://extensions/
```

3. Enable Developer Mode
4. Click "Load Unpacked"
5. Select the `chrome-extension/` folder
6. Open Gmail and start replying to an email

---

# Security Notes

- API keys are stored using environment variables
- `.env` files are excluded using `.gitignore`
- Secrets are never hardcoded into source code

---

# Future Improvements

- Fully reactive backend using Mono/Flux
- Global exception handling using `@ControllerAdvice`
- Redis caching for repeated prompts
- JWT Authentication & User Accounts
- Prompt history storage
- AI streaming responses
- Rate limiting
- Multi-provider AI support

---

# Learning Outcomes

This project helped in understanding:
- REST API development using Spring Boot
- External API integration using WebClient
- AI prompt engineering
- JSON tree parsing using Jackson
- Chrome Extension development
- Gmail DOM manipulation
- React frontend integration
- Full-stack application architecture

---

# Resume Highlights

- Built an AI-powered email assistant using Spring Boot and Gemini API
- Integrated AI-generated responses directly into Gmail using a Chrome Extension
- Designed REST APIs with layered architecture and dynamic prompt generation
- Used Spring WebClient for external API communication
- Implemented context-aware tone customization

---

# Author

Ojas Pratap Singh

GitHub: https://github.com/your-github-username

LinkedIn: https://linkedin.com/in/your-linkedin

---

# License

This project is for educational and portfolio purposes.
