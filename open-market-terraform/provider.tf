terraform {
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "4.35.0"
    }
  }

  # TODO: GCS backend
}

provider "google" {
  project     = var.project_id
  region      = "asia-northeast3"
  zone        = "asia-northeast3-a"
  credentials = "key.json"
}
