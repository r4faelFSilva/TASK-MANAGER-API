package com.taskmanager.dto;

import com.taskmanager.model.Task;
import com.taskmanager.model.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Dados da tarefa retornada")
public class TaskResponse {

    @Schema(description = "ID da tarefa", example = "1")
    private Long id;

    @Schema(description = "Título da tarefa", example = "Estudar Spring Boot")
    private String title;

    @Schema(description = "Descrição da tarefa", example = "Revisar conceitos de Spring Security e JWT")
    private String description;

    @Schema(description = "Status da tarefa", example = "PENDING")
    private TaskStatus status;

    @Schema(description = "Data de criação")
    private LocalDateTime createdAt;

    @Schema(description = "Data de atualização")
    private LocalDateTime updatedAt;

    // Construtores
    public TaskResponse() {
    }

    public TaskResponse(Long id, String title, String description, TaskStatus status,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Método utilitário para converter entidade em DTO
    public static TaskResponse fromEntity(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }

    // Builder pattern
    public static TaskResponseBuilder builder() {
        return new TaskResponseBuilder();
    }

    public static class TaskResponseBuilder {
        private Long id;
        private String title;
        private String description;
        private TaskStatus status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public TaskResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TaskResponseBuilder title(String title) {
            this.title = title;
            return this;
        }

        public TaskResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TaskResponseBuilder status(TaskStatus status) {
            this.status = status;
            return this;
        }

        public TaskResponseBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TaskResponseBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public TaskResponse build() {
            return new TaskResponse(id, title, description, status, createdAt, updatedAt);
        }
    }
}
