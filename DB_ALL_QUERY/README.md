# ON DELETE CASCADE (DatabaseSetupConfig)

```text
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user")),
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role"))
    )
    private List<Role> roleList = new ArrayList<>();
```